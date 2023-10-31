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
          <button className="mt-4 border-red-500 text-red-500 border-2 text-sm text-center py-4 border-gray-300 rounded-2xl w-full">
            Выйти
          </button>
        </div>
        <div className="border border-gray-300 rounded-2xl w-full pl-32">
          <div className="flex mt-8 items-center">
            <div className="bg-gray-300 rounded-full w-[150px] h-[150px]"></div>
            <div className="pl-10 text-blue-500">Изменить фото</div>
          </div>
        </div>
      </div>
    </div>
  );
}
