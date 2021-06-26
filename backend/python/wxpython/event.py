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

class Example(wx.Frame):

   def __init__(self, *args, **kw):
      super(Example, self).__init__(*args, **kw)
      self.InitUI()

   def InitUI(self):
      self.Bind(wx.EVT_MOVE, self.OnMove)
      self.SetSize((250, 180))
      self.SetTitle('Move event')
      self.Centre()
      self.Show(True)

   def OnMove(self, e):
      x, y = e.GetPosition()
      print "current window position x = ",x," y= ",y

ex = wx.App()
Example(None)
ex.MainLoop()
