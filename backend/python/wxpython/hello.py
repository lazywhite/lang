#! /usr/bin/env python
# -*- coding: utf-8 -*-
# vim:fenc=utf-8
#
# Copyright © 2017 white <white@localhost>
#
# Distributed under terms of the MIT license.

"""

"""
import wx

app = wx.App()
window = wx.Frame(None, title = "wxPython Frame", size = (300,200))
panel = wx.Panel(window)
label = wx.StaticText(panel, label = "Hello World", pos = (100,50))
window.Show(True)
app.MainLoop()
