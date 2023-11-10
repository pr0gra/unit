import Link from "next/link";

export default function Projects() {
  return (
    <div className="pb-20">
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="px-6 py-1" href="/">
          О нас
        </Link>
        <Link className="bg-black text-white rounded-full px-6 py-1" href="/p">
          Проекты
        </Link>
        <Link className="px-6 py-1" href="/a">
          Авторы
        </Link>
      </div>
      <div className="max-w-7xl mx-auto mt-10 grid grid-cols-3 gap-3">
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
        <Link
          href="/p/unit"
          className="relative bg-gray-300 rounded-2xl text-white font-bold w-full h-[240px]"
        >
          <div className="absolute bottom-2 left-4">Сайт ПРОФКОМ</div>
        </Link>
      </div>
    </div>
  );
}
