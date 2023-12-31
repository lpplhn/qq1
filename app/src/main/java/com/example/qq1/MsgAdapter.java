package com.example.qq1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{
    private List<Msg> msgList;

    public MsgAdapter(List<Msg> list){
        this.msgList=list;//数据源输入的地方
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout= (LinearLayout) itemView.findViewById(R.id.left_layout);
            rightLayout=(LinearLayout) itemView.findViewById(R.id.right_layout);
            leftMsg= (TextView) itemView.findViewById(R.id.left_msg);
            rightMsg=(TextView) itemView.findViewById(R.id.right_msg);
        }
    }
    @Override
    public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        ViewHolder holder=new ViewHolder(view);//获取布局，初始化ViewHolder
        return holder;
    }

    @Override
    public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {

        Msg msg=msgList.get(position);
        if (msg.getType()==Msg.TYPE_RECEIVED){
            //收到消息后，则显示左边的消息布局，隐藏右边的消息布局
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if (msg.getType()==Msg.TYPE_SENT){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }
}