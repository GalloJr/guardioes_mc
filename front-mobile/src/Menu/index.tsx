import React from 'react';
import { StyleSheet, View } from 'react-native';
import Header from '../Header';
import { useNavigation } from '@react-navigation/native';
import { Button } from '../Components/Button';

export default function Menu() {
    const navigation = useNavigation();

    const handleOnMembers = () => {
        navigation.navigate('MembersMenu');
    }

    const handleOnSchedule = () => {
        navigation.navigate('Schedule');
    }

    return (
        <>
            <Header />
            <View style={styles.content}>
                <Button
                    title="INTEGRANTES"
                    onPress={handleOnMembers}
                />

                <View style={styles.content}>
                    <Button
                        title="AGENDA"
                        onPress={handleOnSchedule}
                    />
                </View>
            </View>
        </>

    );
}

const styles = StyleSheet.create({
    content: {
        flex: 1,
        marginTop: '25%',
        width: '100%'
    }
});
