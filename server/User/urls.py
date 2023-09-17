from django.urls import path
from . import views

'''
     -Authentication:
          [DESCRIPTION]:URL endpoints associated with user authentication
          [POST]:{username:..., password:...} -> returns 
               :response:
                    {"auth_status":"success","auth_data":{"auth_token":"Token ..."}}} -> authentication status successfull
                    {"auth_status":"exception""info":{...}}} -> database integrity error / other exceptions
                    {"auth_status":"denied"} -> authentication failed, onvalid credentials provided
          [GET]:{} -> returns 
               :response:
                    {"auth_status":"authenticated"} -> user is authenticated status successfull
                    {"auth_status":"none"} -> no user is authenticated for the particular request 
'''       
urlpatterns = [
    path('auth/', views.AuthenticationView.as_view())
]
