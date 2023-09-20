from . import views
from django.urls import path
urlpatterns = [
     path('auth/', views.AuthenticationView.as_view()),
     path('get/', views.RegistrationView.as_view())
]
