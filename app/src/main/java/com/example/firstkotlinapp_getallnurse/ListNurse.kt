package com.example.firstkotlinapp_getallnurse

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListNurseScreen(modifier: Modifier = Modifier) {
    // Create a Map of a nurse data
    val nurses = rememberSaveable {
        listOf(
            mapOf(
                "ID" to 1,
                "Name" to "Pedro",
                "Age" to "24",
                "Speciality" to "Enfermero",
                "Password" to "PassPedro1"
            ), mapOf(
                "ID" to 2,
                "Name" to "Antonio",
                "Age" to "42",
                "Speciality" to "Ginecologia",
                "Password" to "PassAntonio1"
            ), mapOf(
                "ID" to 3,
                "Name" to "Maria",
                "Age" to "30",
                "Speciality" to "Pediatria",
                "Password" to "PassMaria1"
            )
        )
    }

    // Render the list into de view
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(items = nurses, itemContent = { nurse ->
            NurseListItem(nurse = nurse)
        })
    }
}

@Composable
fun NurseListItem(nurse: Map<String, Any>) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = "ID Nurse: ${nurse["ID"]}")
                Text(text = "Name: ${nurse["Name"]}")
                Text(text = "Age: ${nurse["Age"]}")
                Text(text = "Speciality: ${nurse["Speciality"]}")
                Text(text = "Password: ${"*".repeat(nurse["Password"].toString().length)}")
            }
        }
    }
}