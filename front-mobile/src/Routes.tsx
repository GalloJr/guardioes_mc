import React from 'react';
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from '@react-navigation/stack';
import Home from "./Home";
import Members from "./Members";
import Visitors from './Visitors';
import MemberDetails from './MemberDetails';

const Stack = createStackNavigator();

function Routes() {
    return (
        <NavigationContainer>
            <Stack.Navigator
            headerMode="none"
            screenOptions={{
                cardStyle:{
                    backgroundColor: '#FFF'
                }
            }}>
                <Stack.Screen name="Home" component={Home}></Stack.Screen>
                <Stack.Screen name="Visitors" component={Visitors}></Stack.Screen>
                <Stack.Screen name="Members"component={Members}></Stack.Screen>
                <Stack.Screen name="MemberDetails"component={MemberDetails}></Stack.Screen>
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default Routes;