# 石头剪刀布小游戏，和电脑对战
import random

print("来玩石头剪刀布！")
print("规则：输入 石头 / 剪刀 / 布 就可以和电脑玩啦")
print("输入 '退出' 可以随时结束游戏")

# 用来统计比分
win = 0
lose = 0
tie = 0

while True:
    # 电脑随机出
    options = ["石头", "剪刀", "布"]
    computer = random.choice(options)

    # 玩家输入
    player = input("\n你出什么？：")
    player = player.strip()  # 去掉多余空格

    if player == "退出":
        print("\n游戏结束！")
        print(f"战绩：赢{win}次 输{lose}次 平{tie}次")
        print("下次再玩！")
        break

    # 简单判断输入是否合法
    if player not in options:
        print("别乱输啊！只能输入石头/剪刀/布！")
        continue

    print(f"你出了：{player}，电脑出了：{computer}")

    # 判断胜负
    if player == computer:
        print("平局！再来一局！")
        tie += 1
    elif (player == "石头" and computer == "剪刀") or \
         (player == "剪刀" and computer == "布") or \
         (player == "布" and computer == "石头"):
        print("你赢了！厉害啊！")
        win += 1
    else:
        print("你输了！别灰心！")
        lose += 1
