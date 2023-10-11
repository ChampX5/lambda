/** @type {import('tailwindcss').Config} */
export default {
    content: ['./src/**/*.{js,jsx,ts,tsx}'],
    theme: {
        extend: {
            colors: {
                white: {
                    100: '#fefefe',
                    200: '#fefefe',
                    300: '#fdfdfd',
                    400: '#fdfdfd',
                    500: '#fcfcfc',
                    600: '#cacaca',
                    700: '#979797',
                    800: '#656565',
                    900: '#323232',
                    'main': '#FFFFFF'
                },
                purple: {
                    100: '#e8e6f9',
                    200: '#d0cef3',
                    300: '#b9b5ee',
                    400: '#a19de8',
                    500: '#8a84e2',
                    600: '#6e6ab5',
                    700: '#534f88',
                    800: '#37355a',
                    900: '#1c1a2d'
                },
                orange: {
                    100: '#ffe8d9',
                    200: '#ffd1b3',
                    300: '#ffba8e',
                    400: '#ffa368',
                    500: '#ff8c42',
                    600: '#cc7035',
                    700: '#995428',
                    800: '#66381a',
                    900: '#331c0d'
                },
                pink: {
                    100: '#f7d2de',
                    200: '#efa5bd',
                    300: '#e8789d',
                    400: '#e04b7c',
                    500: '#d81e5b',
                    600: '#ad1849',
                    700: '#821237',
                    800: '#560c24',
                    900: '#2b0612'
                },
                grey: {
                    100: '#d6d6d6',
                    200: '#adadad',
                    300: '#858585',
                    400: '#5c5c5c',
                    500: '#333333',
                    600: '#292929',
                    700: '#1f1f1f',
                    800: '#141414',
                    900: '#0a0a0a'
                }
            }
        }
    },
    plugins: []
};
