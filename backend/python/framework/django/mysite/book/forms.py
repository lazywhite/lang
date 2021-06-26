from django import forms
from django.forms import ModelForm
from .models import Author, Book, TITLE_CHOICES

class UploadFileForm(forms.Form):
    title = forms.CharField(max_length=50)
    file = forms.FileField()


class AuthorForm(ModelForm):
    class Meta:
        model = Author
        fields = ['name', 'title', 'birth_date']

class BookForm(ModelForm):
    class Meta:
        model = Book
        fields = ['name', 'authors']



#class AuthorForm(forms.Form):
#    name = forms.CharField(max_length=100)
#    title = forms.CharField(
#        max_length=3,
#        widget=forms.Select(choices=TITLE_CHOICES),
#    )
#    birth_date = forms.DateField(required=False)

#class BookForm(forms.Form):
#    name = forms.CharField(max_length=100)
#    authors = forms.ModelMultipleChoiceField(queryset=Author.objects.all())
