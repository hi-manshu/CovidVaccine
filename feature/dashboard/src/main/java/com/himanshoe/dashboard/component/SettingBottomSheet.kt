package com.himanshoe.dashboard.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun SettingBottomSheet() {

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Text(text = "Hello from sheet")
            }
        }, sheetPeekHeight = 0.dp
    ) {
//        Button(onClick = {
//            coroutineScope.launch {
//
//                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
//                    bottomSheetScaffoldState.bottomSheetState.expand()
//                } else {
//                    bottomSheetScaffoldState.bottomSheetState.collapse()
//                }
//            }
//        }) {
//            Text(text = "Expand/Collapse Bottom Sheet")
//        }
    }
}