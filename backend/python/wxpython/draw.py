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

class Mywin(wx.Frame):

   def __init__(self, parent, title):
      super(Mywin, self).__init__(parent, title = title,size = (500,300))
      self.InitUI()

   def InitUI(self):
      self.Bind(wx.EVT_PAINT, self.OnPaint)
      self.Centre()
      self.Show(True)

   def OnPaint(self, e):
      dc = wx.PaintDC(self)
      brush = wx.Brush("white")
      dc.SetBackground(brush)
      dc.Clear()

      dc.DrawBitmap(wx.Bitmap("python.jpg"),10,10,True)
      color = wx.Colour(255,0,0)
      b = wx.Brush(color)

      dc.SetBrush(b)
      dc.DrawCircle(300,125,50)
      dc.SetBrush(wx.Brush(wx.Colour(255,255,255)))
      dc.DrawCircle(300,125,30)

      font = wx.Font(18, wx.ROMAN, wx.ITALIC, wx.NORMAL)
      dc.SetFont(font)
      dc.DrawText("Hello wxPython",200,10)

      pen = wx.Pen(wx.Colour(0,0,255))
      dc.SetPen(pen)
      dc.DrawLine(200,50,350,50)
      dc.SetBrush(wx.Brush(wx.Colour(0,255,0), wx.CROSS_HATCH))
      dc.DrawRectangle(380, 15, 90, 60)

ex = wx.App()
Mywin(None,'Drawing demo')
ex.MainLoop()
