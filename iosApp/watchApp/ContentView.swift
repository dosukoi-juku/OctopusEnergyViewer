//
//  ContentView.swift
//  watchApp Watch App
//
//  Created by Miyayu on 2023/09/11.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ContentView: View {
    let greet = Greeting().greet()

    var body: some View {
        Text(greet)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
