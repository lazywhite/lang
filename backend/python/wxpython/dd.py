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

class MyTarget(wx.TextDropTarget):
   def __init__(self, object):
      wx.TextDropTarget.__init__(self)
      self.object = object

   def OnDropText(self, x, y, data):
      self.object.InsertStringItem(0, data)

class Mywin(wx.Frame):

   def __init__(self, parent, title):
      super(Mywin, self).__init__(parent, title = title,size = (-1,300))
      panel = wx.Panel(self)
      box = wx.BoxSizer(wx.HORIZONTAL)
      languages = ['C', 'C++', 'Java', 'Python', 'Perl', 'JavaScript',
         'PHP', 'VB.NET','C#']

      self.lst1 = wx.ListCtrl(panel, -1, style = wx.LC_LIST)
      self.lst2 = wx.ListCtrl(panel, -1, style = wx.LC_LIST)
      for lang in languages:
        self.lst1.InsertStringItem(0,lang)

      dt = MyTarget(self.lst2)
      self.lst2.SetDropTarget(dt)
      wx.EVT_LIST_BEGIN_DRAG(self, self.lst1.GetId(), self.OnDragInit)

      box.Add(self.lst1,0,wx.EXPAND)
      box.Add(self.lst2, 1, wx.EXPAND)

      panel.SetSizer(box)
      panel.Fit()
      self.Centre()
      self.Show(True)

   def OnDragInit(self, event):
      text = self.lst1.GetItemText(event.GetIndex())
      tobj = wx.PyTextDataObject(text)
      src = wx.DropSource(self.lst1)
      src.SetData(tobj)
      src.DoDragDrop(True)
      self.lst1.DeleteItem(event.GetIndex())

ex = wx.App()
Mywin(None,'Drag&Drop Demo')
ex.MainLoop()

