from flask import Flask, render_template
from helloworld.core import get_msg
app = Flask(__name__)


@app.route("/")
def hello():
    return render_template('index.html',
        msg=get_msg())


def run_server():
    app.run(debug=True)
