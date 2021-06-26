'''
    1.Identify and mark up literal strings in the source code that contain messages to translate
    2.Extract the messages  (xgettext)
    3.Translate the messages
    4."Compile" the message catalog from the translation (msgfmt)
    5.Load and activate the appropriate message catalog at runtime. ($LANG, $LC_ALL)
'''
import gettext

t = gettext.translation('example', localedir='locale', fallback=True)
_ = t.gettext

print(_('This message is in this script'))
