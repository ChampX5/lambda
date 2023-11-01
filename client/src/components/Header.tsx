interface HeaderProps {
    title: string;
    type: string;
};

const Header = (props: HeaderProps) => {
    return (
        <>
            <div className='text-3xl font-semibold md:ml-20 mt-6 text-center md:text-left'>
                {props.title}
            </div>
            <div className='md:ml-20 mt-1 mb-6 text-center md:text-left text-base uppercase text-white-800 font-[Montserrat]'>
                {props.type}
            </div>
        </>
    );
};

export default Header;
