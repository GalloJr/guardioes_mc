import React from 'react';
import { StyleSheet, View } from 'react-native';
import Header from '../../Components/Header';
import { useNavigation } from '@react-navigation/native';
import { Button } from '../../Components/Button';

export default function MembersMenu() {
    const navigation = useNavigation();

    const handleOnMembers = () => {
        navigation.navigate('Members');
    }

    const handleOnNomad = () => {
        navigation.navigate('Nomads');
    }

    const handleOnMemoriam = () => {
        navigation.navigate('Memorian');
    }

    const handleOnDirectors = () => {
        navigation.navigate('Directors');
    }

    return (
        <>
            <Header />
            <View style={styles.content}>
                <Button
                    title="Diretoria"
                    onPress={handleOnDirectors}
                />
                <View style={styles.content}>
                    <Button
                        title="Nomades"
                        onPress={handleOnNomad}
                    />
                    <View style={styles.content}>
                        <Button
                            title="Integrantes"
                            onPress={handleOnMembers}
                        />
                        <View style={styles.content}>
                            <Button
                                title="In Memorian"
                                onPress={handleOnMemoriam}
                            />
                        </View>
                    </View>
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
