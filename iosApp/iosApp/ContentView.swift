import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.text)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var text = "Loading..."
        init() {
            Greeting().greeting { greeting, error in
                DispatchQueue.main.async {
                if let greeting = greeting {
                    self.text = greeting.debugDescription
                } else {
                    self.text = error?.localizedDescription ?? "error"
                }
                }
            }
        }
    }
}
