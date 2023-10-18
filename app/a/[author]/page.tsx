import Link from "next/link";

export default function Author({ params }: { params: any }) {
  return (
    <div className="pb-20">
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
