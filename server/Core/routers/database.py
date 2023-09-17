from Core.configuration import Database

class AuthRouter:
    """
    A router to control all database operations on models in the
    auth and contenttypes applications.
    """

    route_app_labels = {"auth", "contenttypes","sessions","admin"}
    route_app_labels.update({apps for apps in Database.PUBLIC_DATABASE_ACCESSES})
 

    def db_for_read(self, model, **hints):
        """
        Attempts to read auth and contenttypes models go to auth_primary.
        """
        if model._meta.app_label in self.route_app_labels:
            return "auth_primary"
        return None

    def db_for_write(self, model, **hints):
        """
        Attempts to write auth and contenttypes models go to auth_primary.
        """
        if model._meta.app_label in self.route_app_labels:
            return "auth_primary"
        return None

    def allow_relation(self, obj1, obj2, **hints):
        """
        Allow relations if a model in the auth or contenttypes apps is
        involved.
        """
        if (
            obj1._meta.app_label in self.route_app_labels
            or obj2._meta.app_label in self.route_app_labels
        ):
            return True
        return None

    def allow_migrate(self, db, app_label, model_name=None, **hints):
        """
        Make sure the auth and contenttypes apps only appear in the
        'auth_primary' database.
        """
        if app_label in self.route_app_labels:
            return db == "auth_primary"
        return None
   

class ContentRouter:
    """
    A router to control all database operations on models in the
    auth and contenttypes applications.
    """

    route_app_labels = {"admin"}
    route_app_labels.update({apps for apps in Database.PUBLIC_DATABASE_ACCESSES})
 

    def db_for_read(self, model, **hints):
        """
        Attempts to read auth and contenttypes models go to content.
        """
        if model._meta.app_label in self.route_app_labels:
            return "content"
        return None

    def db_for_write(self, model, **hints):
        """
        Attempts to write auth and contenttypes models go to content.
        """
        if model._meta.app_label in self.route_app_labels:
            return "content"
        return None

    def allow_relation(self, obj1, obj2, **hints):
        """
        Allow relations if a model in the auth or contenttypes apps is
        involved.
        """
        if (
            obj1._meta.app_label in self.route_app_labels
            or obj2._meta.app_label in self.route_app_labels
        ):
            return True
        return None

    def allow_migrate(self, db, app_label, model_name=None, **hints):
        """
        Make sure the auth and contenttypes apps only appear in the
        'content' database.
        """
        if app_label in self.route_app_labels:
            return db == "content"
        return None