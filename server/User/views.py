from rest_framework.views import APIView
from rest_framework.permissions import AllowAny
from rest_framework.response import Response
from rest_framework.authtoken.models import Token
from django.http import HttpRequest
from django.contrib.auth.models import User
from django.contrib.auth import authenticate
from django.db import IntegrityError

class AuthenticationView(APIView):
     permission_classes = [AllowAny]
     
     def post(self,request:HttpRequest, *args, **kwargs):
          
          # extracting request data
          try:
               username = request.data.get("username")
               password = request.data.get("password")
          except Exception as e:
               return Response(
                    {
                         "auth_status":"excpetion",
                         "details":{str(e)}
                    }
               )
          
          # runs authentication on the given data
          auth_user = authenticate(
               request,
               username = username,
               password = password
          )
          if(auth_user is None):
               return Response(
                    {"auth_status":"invlaid",}
               )
          
          # deletion of pre-existing tokens that belongs to user
          if (Token.objects.filter(user = auth_user).exists()) :
               Token.objects.get(user = auth_user).delete()
               
          # creation of an authentication token
          try:
               auth_token = Token.objects.create(user = auth_user)
          except Exception as e:
               return Response(
                    {
                         "auth_status":"excpetion",
                         "details":{str(e)}
                    }
               )
          
          return Response(
               {
                    "auth_status":"success",
                    'user':{
                         'Authentication':f'Token {auth_token}'
                    }
               }
          )          
