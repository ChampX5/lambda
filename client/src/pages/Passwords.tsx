// import { useState, useEffect } from 'react';

import { Header } from "../components";

interface PasswordObjectType {
    platform: Company;
    username?: string;
    password: string;
}

interface Company {
    imageUrl: string;
    name: string;
}

const Passwords = () => {
    // const [passwords, setPasswords] = useState([]);

    // useEffect(() => {
    //     const fetchData = async () => {
    //         const res = await fetch('./passwords');
    //         return await res.json();
    //     }

    //     fetchData().then(data => setPasswords(data));
    // }, []);

    // https://besticon-demo.herokuapp.com/
    const passwords: PasswordObjectType[] = [
        {
            username: 'ChampX5',
            password: '1234',
            platform: {
                name: 'YouTube',
                imageUrl:
                    'https://m.youtube.com/static/apple-touch-icon-180x180-precomposed.png'
            }
        },
        {
            username: 'ChampX5',
            password: '12345',
            platform: {
                name: 'Instagram',
                imageUrl:
                    'https://static.cdninstagram.com/rsrc.php/v3/yG/r/De-Dwpd5CHc.png'
            }
        },
        {
            username: 'ChampX5',
            password: '123456',
            platform: {
                name: 'GitHub',
                imageUrl:
                    'https://github.githubassets.com/assets/apple-touch-icon-92bd46d04241.png'
            }
        },
        {
            username: 'ChampX5',
            password: '12341234',
            platform: {
                name: 'GMail',
                imageUrl:
                    'https://www.gstatic.com/images/branding/product/2x/gmail_2020q4_32dp.png'
            }
        },
        {
            username: 'ChampX5',
            password: '1234',
            platform: {
                name: 'Notion',
                imageUrl: 'https://www.notion.so/front-static/favicon.ico'
            }
        },
        {
            username: 'ChampX5',
            password: '12345',
            platform: {
                name: 'Spotify',
                imageUrl:
                    'https://open.spotify.com/favicon.ico?pfhp=2c2ccb58-8a92-4713-a1c0-8b43b3090b49'
            }
        },
        {
            username: 'ChampX5',
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
            username: 'ChampX5',
            password: '1234',
            platform: {
                name: 'Facebook',
                imageUrl:
                    'https://static.xx.fbcdn.net/rsrc.php/v3/yN/r/EWLVhDVJTum.png'
            }
        },
        {
            username: 'ChampX5',
            password: '12345',
            platform: {
                name: 'Twitter',
                imageUrl:
                    'https://abs.twimg.com/responsive-web/client-web-legacy/icon-ios.77d25eba.png'
            }
        },
        {
            username: 'ChampX5',
            password: '123456',
            platform: {
                name: 'Amazon',
                imageUrl: 'https://www.amazon.com/favicon.ico'
            }
        },
        {
            username: 'ChampX5',
            password: '12341234',
            platform: {
                name: 'Wikipedia',
                imageUrl:
                    'https://www.wikipedia.org/static/apple-touch/wikipedia.png'
            }
        }
    ];

    return (
        <>
            <Header title="My Passwords" type="Manager" />

            <div className='grid w-full xl:grid-cols-3 lg:grid-cols-2 md:grid-cols-2 gap-x-3 gap-y-3 px-3'>
                {passwords.map((password) => (
                    <div className='rounded-lg border-gray-200 border-2 border-solid p-3'>
                        {/* company bar */}
                        <div className='flex items-center gap-5'>
                            <img
                                src={password.platform.imageUrl}
                                className='w-12 rounded-lg'
                            />

                            <span className='font-semibold'>
                                {password.platform.name}
                            </span>
                        </div>

                        <hr className='mt-3 border-gray-300 w-11/12 mx-auto' />

                        {/* username */}
                        <div className='mt-3'>
                            <span className='text-sm font-[Montserrat]'>
                                USERNAME:{' '}
                            </span>
                            <span
                                className={`${
                                    password.username
                                        ? 'bg-slate-50 border-slate-200 cursor-pointer select-none'
                                        : 'bg-red-50 border-red-100 cursor-default'
                                } rounded-lg border-2 border-solid px-2 py-1 font-semibold`}
                                onClick={() => {
                                    if (!password.username) return;

                                    navigator.clipboard.writeText(
                                        password.username
                                    );
                                }}
                            >
                                {password.username || 'No username provided.'}
                            </span>
                        </div>

                        {/* password buttons */}
                        <div className='mt-6 flex justify-around w-full'>
                            <button className='rounded-lg bg-blue-500 text-white-main px-3 py-2 text-sm text-center uppercase font-[Montserrat]'>
                                Copy Password
                            </button>
                            <button className='rounded-lg bg-slate-50 border-slate-200 border-2 border-solid px-2 py-1 text-xs text-center uppercase font-[Montserrat]'>
                                View Password
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </>
    );
};

export default Passwords;
