package ni.desmov.dogapiapp.intent

sealed class Intent {
    object GetCatEvent: Intent()
    object None: Intent()
}