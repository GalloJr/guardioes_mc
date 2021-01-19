import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Image, StyleSheet, Text, View } from 'react-native';
import { RectButton, TouchableWithoutFeedback } from 'react-native-gesture-handler';
import Header from '../Header';

export default function Home() {

    const navigation = useNavigation();

    const handleOnPress = () => {
        navigation.navigate('Visitors');
    }
    return (
        <>
            <Header />
            <TouchableWithoutFeedback onPress={handleOnPress}>
            <View style={styles.container}>
                <Image source={require('../assets/logo.png')}/>
            </View>
            </TouchableWithoutFeedback>
        </>

    );
}

const styles = StyleSheet.create(
    {
        container: {
            marginTop: '23%',
            alignItems: 'center'
        }
    }
);
