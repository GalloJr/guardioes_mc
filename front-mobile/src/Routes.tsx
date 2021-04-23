import React from 'react';
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from '@react-navigation/stack';
import Home from "./Home";
import Members from "./Members";
import Visitors from './Visitors';
import MemberDetails from './MemberDetails';
import Menu from './Menu';
import Schedule from './Schedule';
import MembersMenu from './MembersMenu';
import Directors from './Directors';
import Nomads from './Nomads';
import Memorian from './Memorian';
import Login from './Login';

const Stack = createStackNavigator();

function Routes() {
    return (
        <NavigationContainer>
            <Stack.Navigator
                headerMode="none"
                screenOptions={{
                    cardStyle: {
                        backgroundColor: '#FFF'
                    }
                }}>
                <Stack.Screen name="Home" component={Home}></Stack.Screen>
                <Stack.Screen name="Visitors" component={Visitors}></Stack.Screen>
                <Stack.Screen name="Members" component={Members}></Stack.Screen>
                <Stack.Screen name="Nomads" component={Nomads}></Stack.Screen>
                <Stack.Screen name="Memorian" component={Memorian}></Stack.Screen>
                <Stack.Screen name="Directors" component={Directors}></Stack.Screen>
                <Stack.Screen name="MemberDetails" component={MemberDetails}></Stack.Screen>
                <Stack.Screen name="Menu" component={Menu}></Stack.Screen>
                <Stack.Screen name="MembersMenu" component={MembersMenu}></Stack.Screen>
                <Stack.Screen name="Schedule" component={Schedule}></Stack.Screen>
                <Stack.Screen name="Login" component={Login}></Stack.Screen>
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default Routes;