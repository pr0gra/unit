import Link from "next/link";
import localFont from "next/font/local";

const ablation = localFont({ src: "./Ablation-Extra-Bold.otf" });

export default function Home() {
  return (
    <main className="">
      <div className="">
        <div className="border border-b-white pt-[36px]">
          <h2 className={`${ablation.className}`}>создаём реальные проекты</h2>
          <h3 className="text-white">
            Мы делаем приложения <br /> игры и сайты
          </h3>
        </div>
        <div className="bg-gray-500 rounded-xl">
          <div className="">
            <p className="">
              ЮНИТ - это студенческое IT объединение в Екатеринбурге, которое
              базируется на базе экономического университета (УРГЭУ)
            </p>
          </div>
        </div>
      </div>
      <div className="pl-[20px]">
        <div className="pb-[48px]">
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
          <p className="">Мероприятия, которые мы проводим:</p>
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
        <div className="">
          <p className="">
            Мы верим, что уже будучи студентом можно создавать проекты, меняющие
            жизнь людей
          </p>

          <Link className="" href="https://vk.com/unit.usue">
            Стать частью команды
          </Link>
        </div>
      </div>
    </main>
  );
}
