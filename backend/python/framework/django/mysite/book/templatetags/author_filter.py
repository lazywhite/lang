from django import template
register = template.Library()

@register.filter
def conc_name(authors):
    return '|'.join([author.name for author in authors])


