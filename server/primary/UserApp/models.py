from django.contrib.auth.models import User
from Core.labels import Database
from django.db.models import(
     Model,
     CharField,
     DateTimeField,
     BigIntegerField,
     DateField
)

class Profile(Model):
     user_id = BigIntegerField(unique=True, primary_key=True)
     telephone = BigIntegerField(blank=True, null=True)
     address_line1 = CharField(blank=True,max_length=100)
     city = CharField(max_length=40, blank=True, null=True)
     state = CharField(max_length=30, blank=True, null=True)
     country = CharField(max_length=40, blank=True, null=True)
     dob = DateField(blank=True, null=True)
     created_at = DateTimeField(auto_now_add=True)
     edited_at = DateTimeField(auto_now=True)
     
     def __str__(self) -> str:
          return f"{User.objects.using(Database.PRIMARY_DATABASE).get(id=self.user_id)}"
     
     class Meta:
          app_label = 'UserApp'