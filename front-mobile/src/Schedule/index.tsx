import React from 'react';
import { StyleSheet, View, Text, Image } from 'react-native';
import { CalendarList, LocaleConfig } from 'react-native-calendars';
import Header from '../Header';

export default function Schedule() {

    return (
        <>
            <Header />
            <View>
                <CalendarList
                    // https://www.youtube.com/watch?v=xqlBg2VuzDw
                    // https://github.com/wix/react-native-calendars#calendar
                    // Enable horizontal scrolling, default = false
                    horizontal={true}
                    // Enable paging on horizontal, default = false
                    pagingEnabled={true}
                    // Set custom calendarWidth.
                    //calendarWidth={420}
                    // Handler which gets executed on day press. Default = undefined
                    onDayPress={(day) => { console.log('selected day', day.dateString) }}
                    // Collection of dates that have to be marked. Default = {}
                    markedDates={{
                        '2021-03-19': { selected: true, marked: true, selectedColor: 'blue' },
                        '2021-03-16': { marked: true },
                        '2021-03-18': { marked: true, dotColor: 'red', activeOpacity: 0 },
                        '2021-03-10': { disabled: true, disableTouchEvent: true }
                    }}
                    // Specify style for calendar container element. Default = {}
                    style={{
                        borderBottomWidth: 5,
                        borderColor: 'red',
                        height: 400
                    }}
                    // Month format in calendar title. Formatting values: http://arshaw.com/xdate/#Formatting
                    monthFormat={'MMMM yyyy'}
                    // If firstDay=1 week starts from Monday. Note that dayNames and dayNamesShort should still start from Sunday.
                    firstDay={1}
                />
            </View>
            <View style={styles.container}>
                <Text style={styles.textFormat}>
                    {"Data Selecionada:"}
                </Text>
                <Text style={styles.textFormat}>
                    {"xx/xx/xxxx"}
                </Text>
            </View>
            <View style={styles.container}>
                <Image source={require('../assets/ucl.png')} />
            </View>
        </>
    );
}

const styles = StyleSheet.create(
    {
        container: {
            marginTop: '23%',
            alignItems: 'center'
        },
        textFormat: {
            fontWeight: 'bold',
            fontSize: 18,
            lineHeight: 25,
            letterSpacing: -0.24,
            color: '#263238',
            fontFamily: 'OpenSans_700Bold',
            textAlign: 'center'
        }
    }
);

LocaleConfig.locales['br'] = {
    monthNames: ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'],
    monthNamesShort: ['Jan.', 'Fev.', 'Mar', 'Abril', 'Mai', 'Jun', 'Jul.', 'Ago', 'Set.', 'Out.', 'Nov.', 'Dez.'],
    dayNames: ['Domingo', 'Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta', 'Sábado'],
    dayNamesShort: ['Dom.', 'Seg.', 'Ter.', 'Qua.', 'Qui.', 'Sex.', 'Sab.'],
    today: 'Hoje\'hoje'
};
LocaleConfig.defaultLocale = 'br';


