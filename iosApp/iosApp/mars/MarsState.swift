//
//  MarsState.swift
//  iosApp
//
//  Created by TE-Member on 27/12/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import Shared

class MarsState: ObservableObject {
    let viewModel: MarsViewModel
    
    @Published var marsPhoto: [MarsPhoto]  = []
    
    init() {
        viewModel = MarsViewModel()
         
        viewModel.observeMars { mars in
            self.marsPhoto = mars
        }
    }
    
    deinit {
        viewModel.dispose()
    }
}
