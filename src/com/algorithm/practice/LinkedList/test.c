#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

	freopen("water.in", "r", stdin);

	int i, j;
	int n;
	int x[300], x_dajing[300], x_value[300];
	int matrix[300][300];

	scanf("%d", &n);

	for(i=0; i<n; i++)
	{
		scanf("%d", &x[i]);
	}

	for(i=0; i<n; i++)
	{
		for(j=0; j<n; j++)
		{
			scanf("%d", &matrix[i][j]);
		}
	}

	for(i=0; i<n; i++)
	{
		x_dajing[i] = 1;   //初始状态使每个顶点都有井
		x_value[i] = x[i]; //i顶点打井的花费
	}

	int n_dajing = n;
	int changed = 0;
	while(1)
	{
		changed = 0;
		for(i=0; i<n; i++)  //一共有n个顶点
		{
			for(j=0; j<n; j++)
			{
				if(i==j) continue;  //顶点自己到自己 权值是0

				if(x_dajing[i] == 1)
				{                 //如果这个顶点有井
					if(x_value[i] >= (x_value[j] + matrix[i][j])) //如果在这个j顶点打井的花费要高于 在j顶点打井并修管道连到i顶点的钱的话，把这个点的井去掉
					{
						x_value[i] = matrix[i][j]; //????   把这个井的权值设为与它连通E(i,j)边的权值
						x_dajing[i] = 0;    //把这个点的井去掉了
						n_dajing--;            //井的个数减一  这个变量没有用到啊
						changed = 1;
					}
				}else{            //如果这个顶点没有井(井已经被移除过了)
					if(x_value[i] >= (x_value[j] + matrix[i][j])) // 如果 上次与这个顶点连通的边的权值大于 这个顶点与其他边的权值+在其他点打井的花费的和
					{
						x_value[i] = x_value[j] + matrix[i][j];   //把这个井的权值更新成这个较小的值
						changed = 1;
					}
				}
			}
		}
		if(changed == 0)
			break;   //此次循环与上次循环没有任何改变，终止循环
	}

	int min_value = 0;
	for(i=0; i<n; i++)
	{
		min_value += x_value[i];  //有点儿小问题
	}

	freopen("water.out", "w", stdout);

	printf("%d", min_value);

	return 0;
}
