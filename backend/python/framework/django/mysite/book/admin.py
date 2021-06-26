from django.contrib import admin
from .models import Book, Author
from guardian.admin import GuardedModelAdmin


@admin.register(Book)
class BookAdmin(GuardedModelAdmin):
    pass

@admin.register(Author)
class AuthorAdmin(GuardedModelAdmin):
    pass
