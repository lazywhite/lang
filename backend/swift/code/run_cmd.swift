import Foundation

func run_cmd(_ launchPath: String, _ arguments: [String]) -> (Int32, String?){
    let task = Process()
    task.launchPath = launchPath
    task.arguments = arguments

    let pipe = Pipe()
    task.standardOutput = pipe
    task.standardError = pipe
    task.launch()
    let data = pipe.fileHandleForReading.readDataToEndOfFile()
    let output = String(data: data, encoding: String.Encoding.utf8)
    task.waitUntilExit()
    return (task.terminationStatus, output)

}

let (rt, output) = run_cmd("/bin/ls", ["-alh"])
print(rt)
print(output!)
