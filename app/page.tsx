import Link from "next/link";
import localFont from "next/font/local";

const ablation = localFont({ src: "./Ablation-Extra-Bold.otf" });

export default function Home() {
  return (
    <div className="bg-gray-500">
      <Link href="/login" className="fixed top-0 right-0 bg-white rounded-full py-2 px-4 mt-4 mr-4">Войти</Link>
      <div className="flex justify-center py-8">
        <svg
          width="75"
          height="17"
          viewBox="0 0 75 17"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M24.4361 10.1293L26.1278 8.13047V16.989H24.4361V10.1293Z"
            fill="white"
          />
          <path
            d="M37.406 0.0480956H39.0977V7.32688L37.406 9.312V0.0480956Z"
            fill="white"
          />
          <path
            d="M26.1278 9.312V8.13047L26.5038 7.705H37.406V9.312H26.1278Z"
            fill="white"
          />
          <path
            d="M18.1336 5.03703C16.9543 3.09932 14.8303 1.80635 12.406 1.80635C8.69989 1.80635 5.69549 4.82816 5.69549 8.55576C5.69549 11.3716 7.40987 13.7847 9.84607 14.7967L8.66459 16.188C5.86967 14.7994 3.94737 11.9034 3.94737 8.55576C3.94737 3.85711 7.73443 0.0480956 12.406 0.0480956C15.2594 0.0480956 17.7828 1.46914 19.3148 3.64597L18.1336 5.03703Z"
            fill="white"
          />
          <path
            d="M56.485 0.0481661L57.6969 0.0481301L57.6969 15.0783L56.0606 16.999V3.14771L44.2669 17L43.0881 16.9919V15.8656L56.485 0.0481661Z"
            fill="white"
          />
          <path
            d="M61.5602 0H75L73.5902 1.70153H69.6678V6.33349L68.0298 8.25216V1.70153H61.5602V0Z"
            fill="white"
          />
          <path
            d="M1.69173 7.57571H5.26316V9.27724H1.69173V16.9341H0V9.56083L1.69173 7.57571Z"
            fill="white"
          />
        </svg>
      </div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="bg-white rounded-full px-6 py-1" href="/">
          О нас
        </Link>
        <Link className="text-white px-6 py-1" href="/">
          Проекты
        </Link>
        <Link className="text-white px-6 py-1" href="/">
          Авторы
        </Link>
      </div>
      <div className="max-w-4xl w-full mx-auto">
        <div className={`${ablation.className} text-white text-7xl mt-40`}>
          <div>создаём</div>
          <div>реальные</div>
          <div>проекты</div>
        </div>
        <div className="text-white text-2xl mt-4 mb-8">
          <div>Мы делаем приложения</div>
          <div>игры и сайты</div>
        </div>
        <div className="bg-white w-[300px] h-1"></div>
        <div className="bg-neutral-300 rounded-xl w-[360px] mt-20 ml-auto p-6">
          ЮНИТ - это студенческое IT объединение в Екатеринбурге, которое
          базируется на базе экономического университета (УРГЭУ)
        </div>
        <div className="text-white text-center pt-20">
          <div className="">
            <p className="">Навыки, которые мы прокачиваем каждый день: </p>
            <nav className="">
              <ul className="">
                <li className="">
                  <p>Дизайн</p>
                </li>
                <li className="">
                  <p>Программирование</p>
                </li>
                <li className="">
                  <p>3D-моделирование</p>
                </li>
                <li className="">
                  <p>Медиа</p>
                </li>
              </ul>
            </nav>
          </div>
          <div className="">
            <p className="pt-20">Мероприятия, которые мы проводим:</p>
            <nav className="">
              <ul className="">
                <li className="">
                  <p>Собственные лекции</p>
                </li>
                <li className="">
                  <p>Лекции от известных IT-компаний</p>
                </li>
                <li className="">
                  <p>Хакатоны</p>
                </li>
              </ul>
            </nav>
          </div>
          <Link
            className="bg-yellow-500 rounded-full w-[260px] text-center py-2 block mx-auto mt-20"
            href="https://vk.com/unit.usue"
          >
            Стать частью команды
          </Link>
          <div className="py-8 text-white text-center">
            Мы верим, что уже будучи студентом можно создавать проекты, меняющие
            жизнь людей
          </div>
        </div>
      </div>
    </div>
  );
}
