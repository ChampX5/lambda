from rest_framework.authentication import TokenAuthentication

class BaseAuthentication(TokenAuthentication):
     keyword = 'Token'
          
class APIConfiguration:
     REST_FRAMEWORK = {
          'DEFAULT_AUTHENTICATION_CLASSES': [
               'Core.configuration.BaseAuthentication ',
          ],
          'DEFAULT_PERMISSION_CLASSES': [
               'rest_framework.permissions.AllowAny',
          ]
     }
     