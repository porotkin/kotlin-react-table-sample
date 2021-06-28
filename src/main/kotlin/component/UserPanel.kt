package component

import Colors
import hook.useSelectedUser
import kotlinx.css.*
import react.*
import react.dom.div
import styled.css
import styled.styledDiv

external interface UserPanelProps : RProps

private val UserPanel = functionalComponent<UserPanelProps> {
    val user = useSelectedUser()
    div {
        div {
            +"Additional User Information"
        }
        styledDiv {
            css {
                width = 400.px
                borderSpacing = 0.px
                borderCollapse = BorderCollapse.collapse
                whiteSpace = WhiteSpace.nowrap
                borderWidth = 2.px
                borderStyle = BorderStyle.solid
                borderColor = Colors.Stroke.Gray
                marginTop = 20.px
            }
            styledDiv {
                +"Name: ${user?.name ?: "—"}"
            }
            styledDiv {
                +"E-mail: ${user?.email ?: "—"}"
            }
            styledDiv {
                +"Phone: ${user?.phone ?: "—"}"
            }
            styledDiv {
                +"Website: ${user?.website ?: "—"}"
            }
        }
    }
}

fun RBuilder.UserPanel(
    handler: UserPanelProps.() -> Unit,
): ReactElement =
    child(UserPanel) { attrs(handler) }