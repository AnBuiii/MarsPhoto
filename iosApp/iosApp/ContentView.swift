import SwiftUI
import Shared

struct ContentView: View {
    @ObservedObject var state: MarsState


    init() {
        state = MarsState()
    }

    var body: some View {
        List(state.marsPhoto, id: \.id) { recipe in
            Text(recipe.imgSrc)
        }
            .listStyle(PlainListStyle())
    }
}