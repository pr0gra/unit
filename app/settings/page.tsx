import Link from "next/link";

export default function Settings() {
  return (
    <div className="max-w-7xl mx-auto mt-10">
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex gap-4">
        <div className="max-w-[240px] w-full">
          <Link
            href="/settings"
            className="block border text-sm text-center py-4 border-gray-300 rounded-t-2xl"
          >
            Личный профиль
          </Link>
          <Link
            href="/settings"
            className="block border-x text-sm text-center py-4 border-gray-300"
          >
            Редактировать проекты
          </Link>
          <Link
            href="/settings"
            className="block bg-gray-300 border text-sm text-center py-4 border-gray-300 rounded-b-2xl"
          >
            Настройки
          </Link>
          <button className="mt-4 border-red-500 text-red-500 border-2 text-sm flex justify-center items-center py-4 border-gray-300 rounded-2xl w-full">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 24 24"
              strokeWidth="1.5"
              stroke="currentColor"
              className="w-6 h-6"
            >
              <path
                stroke-linecap="round"
                stroke-linejoin="round"
                d="M15.75 9V5.25A2.25 2.25 0 0013.5 3h-6a2.25 2.25 0 00-2.25 2.25v13.5A2.25 2.25 0 007.5 21h6a2.25 2.25 0 002.25-2.25V15M12 9l-3 3m0 0l3 3m-3-3h12.75"
              />
            </svg>
            <div className="pl-2">Выйти</div>
          </button>
        </div>
        <div className="border border-gray-300 rounded-2xl w-full px-32 mb-32 pb-16">
          <div className="flex mt-8 items-center">
            <div className="bg-gray-300 rounded-full w-[150px] h-[150px]"></div>
            <div className="pl-10 text-blue-500 flex items-center">
              <svg
                xmlns="http://www.w3.org/2000/svg"
                fill="none"
                viewBox="0 0 24 24"
                strokeWidth="1.5"
                stroke="currentColor"
                className="w-6 h-6"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  d="M16.862 4.487l1.687-1.688a1.875 1.875 0 112.652 2.652L6.832 19.82a4.5 4.5 0 01-1.897 1.13l-2.685.8.8-2.685a4.5 4.5 0 011.13-1.897L16.863 4.487zm0 0L19.5 7.125"
                />
              </svg>
              <div className="pl-2">Изменить фото</div>
            </div>
          </div>
          <div className="pt-10 grid grid-cols-2 gap-4">
            <div>
              <div className="pl-8 text-gray-500 pb-4">Имя</div>
              <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Фамилия</div>
              <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Электронная почта</div>
              <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Номер телефона</div>
              <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Роль</div>
              <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Пароль</div>
              <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Коротко о себе</div>
              <textarea rows={6} className="bg-gray-300 rounded-2xl py-4 px-8 w-full"></textarea>
            </div>
            <div>
              <div className="pl-8 text-gray-500 pb-4">Умения</div>
              <textarea rows={6} className="bg-gray-300 rounded-2xl py-4 px-8 w-full"></textarea>
            </div>
          </div>
          <div className="pt-4">
            <div className="pl-8 text-gray-500 pb-4">Ссылка на интервью</div>
            <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
          </div>
          <div className="pt-4">
            <div className="pl-8 text-gray-500 pb-4">Ссылка на интервью</div>
            <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
          </div>
          <div className="pt-4">
            <div className="pl-8 text-gray-500 pb-4">Ссылки</div>
            <input className="bg-gray-300 rounded-2xl py-4 px-8 w-full" />
          </div>
        </div>
      </div>
    </div>
  );
}
