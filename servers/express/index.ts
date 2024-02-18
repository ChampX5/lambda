import express from 'express';
import cors from 'cors';

const app = express();
const port = 3001;
app.use(cors());

app.get('/passwords', (req, res) => {
    const passwords = [
        {
            username: '<username>',
            password: '1234',
            platform: {
                name: 'YouTube',
                imageUrl:
                    'https://m.youtube.com/static/apple-touch-icon-180x180-precomposed.png'
            }
        },
        {
            username: '<username>',
            password: '12345',
            platform: {
                name: 'Instagram',
                imageUrl:
                    'https://static.cdninstagram.com/rsrc.php/v3/yG/r/De-Dwpd5CHc.png'
            }
        },
        {
            username: '<username>',
            password: '123456',
            platform: {
                name: 'GitHub',
                imageUrl:
                    'https://github.githubassets.com/assets/apple-touch-icon-92bd46d04241.png'
            }
        },
        {
            username: '<username>',
            password: '12341234',
            platform: {
                name: 'GMail',
                imageUrl:
                    'https://www.gstatic.com/images/branding/product/2x/gmail_2020q4_32dp.png'
            }
        },
        {
            username: '<username>',
            password: '1234',
            platform: {
                name: 'Notion',
                imageUrl: 'https://www.notion.so/front-static/favicon.ico'
            }
        },
        {
            username: '<username>',
            password: '12345',
            platform: {
                name: 'Spotify',
                imageUrl:
                    'https://open.spotify.com/favicon.ico?pfhp=2c2ccb58-8a92-4713-a1c0-8b43b3090b49'
            }
        },
        {
            username: '<username>',
            password: '123456',
            platform: {
                name: 'Outlook',
                imageUrl: 'http://outlook.com/apple-touch-icon.png'
            }
        },
        {
            password: '12341234',
            platform: {
                name: 'Threads',
                imageUrl:
                    'https://static.cdninstagram.com/rsrc.php/v3/yX/r/7RzDLDb3SrS.png'
            }
        },
        {
            username: '<username>',
            password: '1234',
            platform: {
                name: 'Facebook',
                imageUrl:
                    'https://static.xx.fbcdn.net/rsrc.php/v3/yN/r/EWLVhDVJTum.png'
            }
        },
        {
            username: '<username>',
            password: '12345',
            platform: {
                name: 'Twitter',
                imageUrl:
                    'https://abs.twimg.com/responsive-web/client-web-legacy/icon-ios.77d25eba.png'
            }
        },
        {
            username: '<username>',
            password: '123456',
            platform: {
                name: 'Amazon',
                imageUrl: 'https://www.amazon.com/favicon.ico'
            }
        },
        {
            username: '<username>',
            password: '12341234',
            platform: {
                name: 'Chess',
                imageUrl:
                    'https://www.chess.com/bundles/web/favicons/apple-touch-icon.7aaa2d1f.png'
            }
        }
    ];

    res.json(passwords);
});

app.listen(port, () => {
    console.log(`Lambda API listening on port: ${port}`);
});