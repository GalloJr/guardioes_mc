import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Alert, Image, StyleSheet, Text, View } from 'react-native';
import { RectButton } from 'react-native-gesture-handler';
import { fetchMembers, setAllright, setDelayed } from '../api';
import Header from '../Header';
import { Member } from '../types';

type Props = {
    route: {
        params: {
            member: Member;
        }
    }
}

export default function MemberDetails({ route }: Props) {
    const { member } = route.params;
    const navigation = useNavigation();

    const handleSetAllright = () => {
        setAllright(member.id)
            .then(() => {
                Alert.alert(`Integrante ${member.name} em dia!`);
                navigation.navigate('Members');
            })
            .catch(() => {
                Alert.alert(`Hoube um erro ao confirmar a atualização do ${member.name}`);
            })
    }

    const handleSetDelayed = () => {
        setDelayed(member.id)
            .then(() => {
                Alert.alert(`Integrante ${member.name} está com pendencia financeira!`);
                navigation.navigate('Members');
            })
            .catch(() => {
                Alert.alert(`Hoube um erro ao confirmar a atualização do ${member.name}`);
            })
    }

    const handleOnBack = () => {
        navigation.navigate('Members');
    }

    return (
        <>
            <Header />
            <Text>{member.imageUri}</Text>
            <View style={styles.container}>
                <View style={styles.header}>
                    <Text style={styles.memberName}>{member.name}</Text>
                    <Text style={styles.memberRank}>{member.rank}</Text>
                </View>
                <Text style={styles.text}>Membro desde {member.since}</Text>
                <Text style={styles.text}>Padrinho {member.sponsor}</Text>
                <Text style={styles.text}>Moto {member.motorcycle}</Text>
            </View>
            <RectButton style={styles.button} onPress={handleSetAllright}>
                <Text style={styles.buttonText}>FINANCEIRO EM DIA</Text>
            </RectButton>
            <RectButton style={styles.button} onPress={handleSetDelayed}>
                <Text style={styles.buttonText}>FINANCEIRO EM ATRASO</Text>
            </RectButton>
            <RectButton style={styles.button} onPress={handleOnBack}>
                <Text style={styles.buttonText}>VOLTAR</Text>
            </RectButton>
        </>
    );
}

const styles = StyleSheet.create(
    {
        container: {
            marginTop: '10%',
            marginLeft: '2%',
            marginRight: '2%',
            marginBottom: '2%',
            padding: 15,
            backgroundColor: '#FFF',
            shadowOpacity: 0.25,
            shadowColor: '#000',
            shadowOffset: { width: 0, height: 4 },
            shadowRadius: 20,
            borderRadius: 10,
            elevation: 5
        },
        button: {
            backgroundColor: '#FF0000',
            flexDirection: 'row',
            borderRadius: 10,
            marginTop: 40,
            alignItems: 'center',
            justifyContent: 'center'
        },
        buttonText: {
            paddingTop: 15,
            paddingBottom: 15,
            paddingLeft: 50,
            paddingRight: 50,
            fontWeight: 'bold',
            fontSize: 18,
            color: '#FFF',
            letterSpacing: -0.24,
            fontFamily: 'OpenSans_700Bold'
        },
        header: {
            flexDirection: 'row',
            justifyContent: 'space-between'
        },
        text: {
            fontWeight: 'normal',
            fontSize: 14,
            lineHeight: 19,
            letterSpacing: -0.24,
            color: '#9E9E9E',
            fontFamily: 'OpenSans_400Regular'
        },
        memberName: {
            fontWeight: 'bold',
            fontSize: 18,
            lineHeight: 25,
            letterSpacing: -0.24,
            color: '#263238',
            fontFamily: 'OpenSans_700Bold'
        },
        memberRank: {
            fontWeight: 'bold',
            fontSize: 18,
            lineHeight: 25,
            textAlign: 'right',
            letterSpacing: -0.24,
            color: '#FF0000',
            fontFamily: 'OpenSans_700Bold'
        }
    }
);
