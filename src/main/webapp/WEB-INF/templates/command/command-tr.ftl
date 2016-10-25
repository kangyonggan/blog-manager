<tr>
    <td>${command.id}</td>
    <td>${command.apiCode}</td>
    <td>${command.params!''}</td>
    <td>${command.status}</td>
    <td id="show-${command.id}">
        <#if command.result?? && command.result!=''>
            ${command.result?substring(0, 25)}... | <span style="cursor: pointer" onclick="document.getElementById('show-${command.id}').className='hidden';document.getElementById('hide-${command.id}').className='';">查看全部</span>
        </#if>
    </td>
    <td width="40%" class="hidden" id="hide-${command.id}">
        ${command.result} | <span style="cursor: pointer" onclick="document.getElementById('hide-${command.id}').className='hidden';document.getElementById('show-${command.id}').className='';">隐藏</span>
    </td>
    <td>${(command.isDeleted==0)?string('未删除', '已删除')}</td>
    <td>${command.createdTime?datetime}</td>
</tr>