# -*- coding: utf-8 -*-
from reportlab.pdfgen import canvas

c = canvas.Canvas("sample.pdf")
c.drawString(0, 0, "hello world")
c.showPage()
c.save()

