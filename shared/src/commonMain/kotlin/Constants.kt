const val SERVER_PORT = 8080

const val SERVER_URL = "10.10.10.106"

const val MARS_ENDPOINT = "photos"

{
    "name": "composeApp",
    "type": "android-app",
    "workingDir": "/Users/te-member/Developer/MarsPhoto",
    "allowParallelRun": true,
    "module": "MarsPhoto.composeApp.main",
    "destination": "samsung SM-A515F"
}

{
    "name": "iosApp",
    "type": "xcode-app",
    "workingDir": "/Users/te-member/Developer/MarsPhoto",
    "buildTarget": {
        "project": "iosApp",
        "target": "iosApp"
                   },
    "configuration": "Debug",
    "destination": ""
}

