.. title:: this is test page

Page all
************************
There should only be one of these per page and this will also -- when
converting to pdf -- be used for the chapters.

H2 -- Page Sections
===================

H3 -- Subsection
----------------

H4 -- Subsubsection
+++++++++++++++++++

.. _my-reference-label:

Section to cross-reference
--------------------------
This is the text of the section.

- bullet list 01
- bullet list 02

#. ordered list 01
#. ordered list 02

include example

.. include:: content.rst

COMPLEX TABLE:

+------------+------------+-----------+
| Header 1   | Header 2   | Header 3  |
+============+============+===========+
| body row 1 | column 2   | column 3  |
+------------+------------+-----------+
| body row 2 | Cells may span columns.|
+------------+------------+-----------+
| body row 3 | Cells may  | - Cells   |
+------------+ span rows. | - contain |
| body row 4 |            | - blocks. |
+------------+------------+-----------+

SIMPLE TABLE:

=====  =====  ======
   Inputs     Output
------------  ------
  A      B    A or B
=====  =====  ======
False  False  False
True   False  True
False  True   True
True   True   True
=====  =====  ======


`Docs for this project <http://packages.python.org/an_example_pypi_project/>`_

.. _is_sweaty:
.. figure::  _static/images/sweat.jpg
   :align:   center

   Proof that getting rich is mostly luck.

anchor to  picture is_sweaty_.

.. image:: _static/images/sweat.jpg



This is a statement.

.. warning::

   Never, ever, use this code!

.. versionadded:: 0.0.1

It's okay to use this code.


Here is something I want to talk about::

    def my_fn(foo, bar=True):
        """A really useful function.

        Returns None
        """

This is inline ``if __name__ == '__main__':``

I really like the :mod:`threading` module which has the
:class:`threading.Thread` class.

Here is a link :func:`time.time`.


:download:`this example script <code/example.py>`.


.. todo::

   this is a paragraph for todo
