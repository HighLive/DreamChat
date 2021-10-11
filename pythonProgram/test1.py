# -*- coding: utf-8 -*-
"""
Created on Fri Oct  8 17:35:57 2021

@author: jinh2
"""

import sys

def getUrlLength(url):
    lenOfURL = len(url)
    print("Length of URL: " + str(lenOfURL))


def main(argv):
    getUrlLength(argv[1])

if __name__ == "__main__":
    main(sys.argv)