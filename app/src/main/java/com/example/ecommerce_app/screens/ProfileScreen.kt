package com.example.ecommerce_app.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.HeadsetMic
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ecommerce_app.components.BottomNav
import com.example.ecommerce_app.model.AccountMenuItem
import com.example.ecommerce_app.model.UserInfo



val mainItems = listOf(
    AccountMenuItem(Icons.Default.ShoppingBag,"My Orders"),
    AccountMenuItem(Icons.Default.Person,"My Details"),
    AccountMenuItem(Icons.Default.Home,"Address Book"),
    AccountMenuItem(Icons.Default.CreditCard,"Payment Methods"),
    AccountMenuItem(Icons.Default.Notifications,"Notifications"),
)
val supportItems = listOf(
    AccountMenuItem(Icons.AutoMirrored.Filled.HelpOutline,"FAQs"),
    AccountMenuItem(Icons.Default.HeadsetMic,"Help Center"),
)


@Composable
fun ProfileScreen(
    userInfo: UserInfo,
    navController: NavController,
    onLogout: (UserInfo) -> Unit
) {
    Scaffold(
        bottomBar = {
            BottomNav(navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 24.dp)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )

                Spacer(modifier = Modifier.width(16.dp))

                if (userInfo.isSignedUp) {

                    Column(
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = userInfo.name,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF1C1C1E)
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = userInfo.mail,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color(0xFF8A8A8A)
                        )
                    }
                }else{
                    Button(
                        onClick = { navController.navigate("signup")},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF111111),
                            contentColor = Color.White
                        ),
                        shape = RoundedCornerShape(12.dp),
                    ) {
                        Text(
                            text = "SIGN UP"
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            MenuSection{
                mainItems.forEachIndexed { index, item ->
                    ProfileItem(
                        icon = item.icon,
                        label = item.label,
                    )
                    if (index < mainItems.lastIndex) {
                        RowDivider()
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            MenuSection {
                supportItems.forEachIndexed { index, item ->
                    ProfileItem(
                        icon = item.icon,
                        label = item.label,
                    )
                    if (index < supportItems.lastIndex) {
                        RowDivider()
                    }
                }
            }


            Spacer(modifier = Modifier.height(8.dp))

            MenuSection{
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 16.dp)
                        .clickable(onClick = {
                            onLogout(UserInfo("","","",false))
                        }),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = "Logout",
                        tint = Color(0xFFE53935),
                        modifier = Modifier.size(22.dp)
                    )
                    Text(
                        text = "Logout",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color =  Color(0xFFE53935)
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}



@Composable
fun ProfileItem(
    icon: ImageVector,
    label: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color(0xFF1C1C1E),
            modifier = Modifier.size(22.dp)
        )

        Spacer(modifier = Modifier.width(14.dp))


        Text(
            text = label,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF1C1C1E),
            modifier = Modifier.weight(1f)
        )


        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
            contentDescription = null,
            modifier = Modifier.size(14.dp)
        )
    }
}


@Composable
private fun MenuSection(
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.5.dp)
    ) {
        Column { content() }
    }
}

@Composable
private fun RowDivider() {
    HorizontalDivider(
        modifier = Modifier.padding(start = 56.dp, end = 20.dp),
        thickness = 0.8.dp,
        color = Color(0xFFEEEEEE)
    )
}
