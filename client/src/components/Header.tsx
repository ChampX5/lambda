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
            <div className='md:ml-20 mt-1 mb-6 text-center md:text-left text-lg text-white-600 font-[Montserrat] font-semibold'>
                {props.type}
            </div>
        </>
    );
};

export default Header;
