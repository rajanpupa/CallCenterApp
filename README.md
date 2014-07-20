CallCenterApp
=============

A Java Swing application to ease tasks of a call center

The input is a input.csv file which has some records in particular format.
When the load activity is triggered, this file is loaded and a jlist is created in the left control panel. Clicking on the element on control panel will display a form in the property panel(right panel) with the corresponding fields in the record. You could change the record and save it and then again click save action to save the file in csv format.

The code is divided into core pacakges and extended packages. The purpose of the core packages is to act as a swing api, so that i could evolve as a generic framework for simple swing applications. Just extend the classes of the core packages, extend the core.com.rukh.green.AbstractControlPanel and core.com.rukh.greenPropertyPanel.AbstractPropertyPanel. You could also extend , extend the core.com.rukh.green.BaseFrame if you want more actions in the top-bar.
