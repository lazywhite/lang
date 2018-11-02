import Foundation

let fm = FileManager()
print(fm.currentDirectoryPath)
print(fm.homeDirectoryForCurrentUser)
print(fm.homeDirectory(forUser: "white")!)
