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
      super(Mywin, self).__init__(parent, title = title,size = (200,150))
      panel = wx.Panel(self)
      vbox = wx.BoxSizer(wx.VERTICAL)

      self.btn = wx.Button(panel,-1,"click Me")
      vbox.Add(self.btn,0,wx.ALIGN_CENTER)
      self.btn.Bind(wx.EVT_BUTTON,self.OnClicked)

      self.tbtn = wx.ToggleButton(panel , -1, "click to on")
      vbox.Add(self.tbtn,0,wx.EXPAND|wx.ALIGN_CENTER)
      self.tbtn.Bind(wx.EVT_TOGGLEBUTTON,self.OnToggle)

      hbox = wx.BoxSizer(wx.HORIZONTAL)

      bmp = wx.Bitmap("NEW.BMP", wx.BITMAP_TYPE_BMP)
      self.bmpbtn = wx.BitmapButton(panel, id = wx.ID_ANY, bitmap = bmp,
         size = (bmp.GetWidth()+10, bmp.GetHeight()+10))

      hbox.Add(self.bmpbtn,0,wx.ALIGN_CENTER)
      self.bmpbtn.Bind(wx.EVT_BUTTON,self.OnClicked)
      self.bmpbtn.SetLabel("NEW")

      bmp1 = wx.Bitmap("OPEN.BMP", wx.BITMAP_TYPE_BMP)
      self.bmpbtn1 = wx.BitmapButton(panel, id = wx.ID_ANY, bitmap = bmp1,
         size = (bmp.GetWidth()+10, bmp.GetHeight()+10))

      hbox.Add(self.bmpbtn1,0,wx.ALIGN_CENTER)
      self.bmpbtn1.Bind(wx.EVT_BUTTON,self.OnClicked)
      self.bmpbtn1.SetLabel("OPEN")

      bmp2 = wx.Bitmap("SAVE.BMP", wx.BITMAP_TYPE_BMP)
      self.bmpbtn2 = wx.BitmapButton(panel, id = wx.ID_ANY, bitmap = bmp2,
         size = (bmp.GetWidth()+10, bmp.GetHeight()+10))

      hbox.Add(self.bmpbtn2,0,wx.ALIGN_CENTER)
      self.bmpbtn2.Bind(wx.EVT_BUTTON,self.OnClicked)
      self.bmpbtn2.SetLabel("SAVE")

      vbox.Add(hbox,1,wx.ALIGN_CENTER)
      panel.SetSizer(vbox)

      self.Centre()
      self.Show()
      self.Fit()

   def OnClicked(self, event):
      btn = event.GetEventObject().GetLabel()
      print "Label of pressed button = ",btn

   def OnToggle(self,event):
      state = event.GetEventObject().GetValue()

      if state == True:
         print "Toggle button state off"
         event.GetEventObject().SetLabel("click to off")
      else:
         print " Toggle button state on"
         event.GetEventObject().SetLabel("click to on")

app = wx.App()
Mywin(None,  'Button demo')
app.MainLoop()
