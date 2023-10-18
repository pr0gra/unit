import Link from "next/link";

export default function Author({ params }: { params: any }) {
  return (
    <div className="pb-20">
      <div className="fixed top-0 right-0 rounded-full mt-8 mr-8 flex items-center gap-3 border border-gray-300 pr-4">
        <div className="bg-gray-300 h-[48px] w-[48px] rounded-full"></div>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          fill="none"
          viewBox="0 0 24 24"
          stroke-width="1.5"
          stroke="currentColor"
          className="w-4 h-4 stroke-gray-500"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            d="M19.5 8.25l-7.5 7.5-7.5-7.5"
          />
        </svg>
      </div>
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="px-6 py-1" href="/">
          О нас
        </Link>
        <Link className="px-6 py-1" href="/">
          Проекты
        </Link>
        <Link className="px-6 py-1" href="/">
          Авторы
        </Link>
      </div>
      <div className="flex justify-center gap-6 items-center mt-20">
        <div className="bg-gray-300 rounded-full h-[150px] w-[150px]"></div>
        <div>
          <div className="text-3xl">Григорий Маманов</div>
          <div className="text-gray-500">Программист</div>
        </div>
      </div>
      <div className="max-w-7xl mx-auto mt-10">
        <div className="flex text-sm space-x-8">
          <Link className="bg-black text-white rounded-full px-6 py-1" href="/">
            Участие в проектах
          </Link>
          <Link className="px-6 py-1" href="/">
            Публикации
          </Link>
          <Link className="px-6 py-1" href="/">
            Об авторе
          </Link>
        </div>
        <div className="mt-10 grid grid-cols-3 gap-2">
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
          <div className="rounded-2xl w-full bg-gray-300 h-[200px]"></div>
        </div>
      </div>
    </div>
  );
}
